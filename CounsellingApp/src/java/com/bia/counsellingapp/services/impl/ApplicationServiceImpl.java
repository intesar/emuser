/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.counsellingapp.services.impl;

import com.abbhsoft.jpadaoframework.dao.PagingParams;
import com.bia.counsellingapp.dao.CollegeDao;
import com.bia.counsellingapp.dao.CollegeDepartmentDao;
import com.bia.counsellingapp.dao.CollegeDepartmentSeatsStatusDao;
import com.bia.counsellingapp.dao.ReservationDao;
import com.bia.counsellingapp.dao.ReservationRuleDao;
import com.bia.counsellingapp.dao.UserAppliedDepartmentDao;
import com.bia.counsellingapp.dao.UsersDao;
import com.bia.counsellingapp.entity.College;
import com.bia.counsellingapp.entity.CollegeDepartment;
import com.bia.counsellingapp.entity.CollegeDepartmentSeatsStatus;
import com.bia.counsellingapp.entity.ReservationRule;
import com.bia.counsellingapp.entity.UserAppliedDepartment;

import com.bia.counsellingapp.entity.Users;
import com.bia.counsellingapp.services.ApplicationService;

import com.bia.counsellingapp.util.PriorityComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @author intesar
 */
public class ApplicationServiceImpl implements ApplicationService {

    public List<String> getCollegeNames(String username) {
        Users u = this.usersDao.findByUsername(username);
        String gender = u.getGender();
        return this.collegeDao.findAllCollegeNames(gender);
    }

    public List<String> getDepartmentNames(String collegeName) {
        return this.collegeDepartmentDao.findByCollege(collegeName);
    }

    public void apply(String username, String college, String department, Integer priority, Date dt) {
        Users user = this.usersDao.findByUsername(username);
        Integer userId = user.getId();

        UserAppliedDepartment uad = this.userAppliedDepartmentDao.findByUserIdAndCollegeAndDepartment(userId, college, department);
        List<UserAppliedDepartment> list = this.userAppliedDepartmentDao.findByUserId(userId);
        if (priority == null || priority <= 0) {
            priority = list.size() + 1;
        }
        if (uad == null) {
            uad = new UserAppliedDepartment(null, userId, college, department, priority, dt);
            this.userAppliedDepartmentDao.create(uad);
        } else {
            uad.setPriority(priority);
            uad.setRegisterDate(dt);
            this.userAppliedDepartmentDao.update(uad);
        }

        List<UserAppliedDepartment> list1 = this.userAppliedDepartmentDao.findByUserIdAndPriority(userId, priority);
        for (UserAppliedDepartment ad : list1) {
            ad.setPriority(ad.getPriority() + 1);
            this.userAppliedDepartmentDao.update(ad);
        }

    }

    public void deleteApplication(Integer id) {
        UserAppliedDepartment uad = this.userAppliedDepartmentDao.read(id);
        this.userAppliedDepartmentDao.delete(uad);
    }

    public List<UserAppliedDepartment> getAppliedDetails(String username) {
        Users u = this.usersDao.findByUsername(username);
        List<UserAppliedDepartment> list = this.userAppliedDepartmentDao.findByUserId(u.getId());
        Collections.sort(list, new PriorityComparator());
        return list;
    }

    public void deleteAllReservationRules() {
        //this.collegeDepartmentSeatsStatusDao.findAndDeleteAll();
        for (int i = 2; i < 10; i++) {
            College c = new College("shadan" + i);
            c.setCity("hyd");
            c.setGender("f");
            c.setUniversity("jntu");
            this.collegeDao.create(c);
        }

    }

    public void createReservationData() {
        // delete all 

        List<CollegeDepartment> cds = this.collegeDepartmentDao.readAll().getResults();
        for (CollegeDepartment cd : cds) {
            List<ReservationRule> rrs = this.reservationRuleDao.findByMaxSeats(cd.getMaxSeats());
            System.out.println("size : " + rrs.size());
            for (ReservationRule rr : rrs) {
                CollegeDepartmentSeatsStatus cdss = new CollegeDepartmentSeatsStatus(cd.getCollegeDepartmentPK().getCollege(),
                        cd.getCollegeDepartmentPK().getDepartment(), rr.getReservationRulePK().getName());
                cdss.setMaleTotalSeats(rr.getMaleReserveSeats());
                cdss.setFemaleTotalSeats(rr.getFemaleReserveSeats());
                this.collegeDepartmentSeatsStatusDao.create(cdss);
                System.out.println(cdss.toString());
            //break;
            }
        }
    }

    public void processAdmissions() {
        // count no of iterations
//        int count = 1;
//        List<Reversation> reservations = this.reservationDao.findAllByPriority();
//        List<ReservationRule> reservationRules = this.reservationRuleDao.readAll().getResults();
//        List<CollegeDepartmentSeatsStatus> collegeDepartmentSeatsStatuses = this.collegeDepartmentSeatsStatusDao.readAll().getResults();
        // iterate all users based on there merit or rank
        List<Users> users = this.usersDao.findAllOrderbyRank();
        for (Users u : users) {
            // if u is not admitted
            if (!u.isAdmitted()) {
                // get users top priority application
                List<UserAppliedDepartment> uads = this.userAppliedDepartmentDao.findByIdOrderByPriority(u.getId());
                System.out.println("avail : " + uads.toString());
                for (UserAppliedDepartment uad : uads) {
                    //UserAppliedDepartment uad = this.userAppliedDepartmentDao.findByUserIdAndTopPriority(u.getId(), u.getId());
                    // get college department info
                    CollegeDepartment cd = this.collegeDepartmentDao.findByCollegeAndDepartment(uad.getCollege(), uad.getDepartment());
                    // if department has seats then try for admission
                    System.out.println("avail : " + cd.getCollegeDepartmentPK().getDepartment());
                    if (cd.getMaxSeats() > cd.getFilledSeats()) {
                        // get reservationrule 
                        //for (int i = 0; i < reservationNames.length; i++ ) {
                        //this.reservationRuleDao.findByNameAndMaxSeats(r.getName(), cd.getMaxSeats());                    
                        String r = reservationNames[0];
                        //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                        CollegeDepartmentSeatsStatus cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                        //System.out.println("avail : " + cdss.getAvailableSeats());
                        if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                            admitUser(u, r, uad, cdss, cd);
                            break;
                        } else if (u.getCaste().equalsIgnoreCase(reservationNames[1])) {
                            r = reservationNames[1];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.isNccAccCertified()) {
                            r = reservationNames[7];
                            //System.out.println ( cd.getCollegeDepartmentPK().geCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.isSportGamesCertified()) {
                            r = reservationNames[8];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.isExtraCurricular()) {
                            r = reservationNames[9];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.isParentExServicemen()) {
                            r = reservationNames[10];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.isPhysicallyHandicap()) {
                            r = reservationNames[11];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        } else if (u.getGender().contains("f")) {
                            r = reservationNames[12];
                            //System.out.println ( cd.getCollegeDepartmentPK().getCollege()+ " " + cd.getCollegeDepartmentPK().getDepartment()+ " " + r + " " + cd.getMaxSeats() );
                            cdss = this.collegeDepartmentSeatsStatusDao.findByCollegeAndDepartmentAndName(cd.getCollegeDepartmentPK().getCollege(), cd.getCollegeDepartmentPK().getDepartment(), r);
                            if (cdss != null && ((cdss.getMaleAvailableSeats() > 0 && u.getGender().equals("m")) ||
                                    (cdss.getFemaleAvailableSeats() > 0 && u.getGender().equals("f")))) {
                                admitUser(u, r, uad, cdss, cd);
                                break;
                            }
                        }
                    }

                }
            }
        }
    }

    public List<Users> getUserApplicationStatus(String hallTicketNos) {
        List<Users> list = new ArrayList<Users>();
        if (hallTicketNos != null && hallTicketNos.contains("-")) {
            String halls[] = hallTicketNos.split("-");
            int hallTicketNo1 = Integer.parseInt(halls[0]);
            int hallTicketNo2 = Integer.parseInt(halls[1]);
            return this.usersDao.findByHallTicketNos(hallTicketNo1, hallTicketNo2);
        } else if (hallTicketNos != null && hallTicketNos.length() > 0) {
            Integer hallTicketNo = Integer.parseInt(hallTicketNos);

            list.add(this.usersDao.findByHallTicketNo(hallTicketNo));
            return list;
        }
        PagingParams pp = new PagingParams();
        pp.setLimit(1000);
        return this.usersDao.readAll(pp).getResults();
    }

    public List<CollegeDepartment> getCollegeDepartments(String collegeName) {
        return this.collegeDepartmentDao.findByCollegeName(collegeName);
    }

    public List<CollegeDepartmentSeatsStatus> getCollegeReservations(String collegeName) {
        return this.collegeDepartmentSeatsStatusDao.findByCollegeName(collegeName);
    }

    public void addUser(String name, String username, String password, String fathersName, Integer hallTicketNo, String rank) {
        Users u = this.usersDao.findByHallTicketNo(hallTicketNo);
        System.out.println(name + " " + fathersName + " " + hallTicketNo + " " + rank);
        System.out.println(u.getName() + " " + u.getFathersName() + " " + u.getHallTicketNo() + " " + u.getRank());
        if (u != null && u.getName().equals(name) && u.getFathersName().equals(fathersName) && u.getRank().equals(Integer.parseInt(rank))) {
            if (u.getUsername() != null && u.getUsername().length() > 0) {
                throw new RuntimeException("This user is already registerd with us, if you forgot your password please use " +
                        "forgot password page !");

            }
            u.setUsername(username);
            u.setPassword(password);
            u.setEnabled(true);
            this.usersDao.update(u);
        } else {
            throw new RuntimeException("Please provide correct information ");
        }

    }
    private String[] reservationNames = {"merit", "scheduled castes", "scheduled tribes",
        "backward classes group a ", "backward classes group b", "backward classes group c",
        "backward classes group d", "ncc acc", "sports & games", "extra curricular activities",
        "children of ex servicemen", "physically handicapped", "women"
    };

    private void admitUser(Users u, String r, UserAppliedDepartment uad, CollegeDepartmentSeatsStatus cdss, CollegeDepartment cd) {
        System.out.println(" inside ");
        u.setAdmissionCriteria(r);
        u.setAdmitted(true);
        u.setCollege(uad.getCollege());
        u.setDepartment(uad.getDepartment());
        this.usersDao.update(u);
        uad.setDecision("accepted");
        this.userAppliedDepartmentDao.update(uad);
        if (u.getGender().equals("m")) {
            cdss.setMaleAvailableSeats(cdss.getMaleAvailableSeats() - 1);
        } else {
            cdss.setFemaleAvailableSeats(cdss.getFemaleAvailableSeats() - 1);
        }
        this.collegeDepartmentSeatsStatusDao.update(cdss);
        cd.setFilledSeats(cd.getFilledSeats() + 1);
        return;
    }
    // setters and getters
    public void setCollegeDao(CollegeDao collegeDao) {
        this.collegeDao = collegeDao;
    }

    public void setCollegeDepartmentDao(CollegeDepartmentDao collegeDepartmentDao) {
        this.collegeDepartmentDao = collegeDepartmentDao;
    }

    public void setUserAppliedDepartmentDao(UserAppliedDepartmentDao userAppliedDepartmentDao) {
        this.userAppliedDepartmentDao = userAppliedDepartmentDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }

    public void setReservationDao(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public void setReservationRuleDao(ReservationRuleDao reservationRuleDao) {
        this.reservationRuleDao = reservationRuleDao;
    }

    public void setCollegeDepartmentSeatsStatusDao(CollegeDepartmentSeatsStatusDao collegeDepartmentSeatsStatusDao) {
        this.collegeDepartmentSeatsStatusDao = collegeDepartmentSeatsStatusDao;
    }
    private UsersDao usersDao;
    private UserAppliedDepartmentDao userAppliedDepartmentDao;
    private CollegeDao collegeDao;
    private CollegeDepartmentDao collegeDepartmentDao;
    private ReservationRuleDao reservationRuleDao;
    private ReservationDao reservationDao;
    private CollegeDepartmentSeatsStatusDao collegeDepartmentSeatsStatusDao;
}
