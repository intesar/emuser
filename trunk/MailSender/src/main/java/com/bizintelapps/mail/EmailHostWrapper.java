package com.bizintelapps.mail;

/**
 *
 * @author intesar
 * 
 * @param host "smtp.gmail.com"
 * @param port "465"
 * @param from "faceguard3@bizintelapps.com" 
 * @param password "secret"
 * 
 */
public class EmailHostWrapper {

    private String host;
    private String port;
    private String from;
    private String password;

    /**
     * 
     * @param host
     * @param port
     * @param from
     * @param username
     * @param password
     */
    public EmailHostWrapper(String host, String port, String from, String password) {
        this.host = host;
        this.port = port;
        this.from = from;
        this.password = password;
    }

    public EmailHostWrapper() {
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmailHostWrapper other = (EmailHostWrapper) obj;
        if (this.host != other.host && (this.host == null || !this.host.equals(other.host))) {
            return false;
        }
        if (this.port != other.port && (this.port == null || !this.port.equals(other.port))) {
            return false;
        }
        if (this.from != other.from && (this.from == null || !this.from.equals(other.from))) {
            return false;
        }
        if (this.password != other.password && (this.password == null || !this.password.equals(other.password))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.host != null ? this.host.hashCode() : 0);
        hash = 13 * hash + (this.port != null ? this.port.hashCode() : 0);
        hash = 13 * hash + (this.from != null ? this.from.hashCode() : 0);
        hash = 13 * hash + (this.password != null ? this.password.hashCode() : 0);
        return hash;
    }
}
