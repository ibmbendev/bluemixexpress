/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yazilimkulubu.bluemixexpress;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

/**
 *
 * @author ahmet
 */
public class BlueMixExpress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlueMixExpress e = new BlueMixExpress();
        e.login("amungen@gmail.com", "agg");
        //e.uploadwar();

    }

    public void api() {
        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cf api https://api.ng.bluemix.net");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (Exception e) {
        }

    }

    public String login(String username, String password) {
        String line = "";
        String lineb = "";

        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cf login -u " + username + " -p " + password);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                lineb = lineb + line;
            }

        } catch (Exception e) {
        }
        System.out.println("lineb = " + lineb);
        if (lineb.indexOf("Credentials were rejected") > -1) {
            line = "false,System  were rejected Credentials";
        } else if (lineb.indexOf("Authenticating...OK") > -1) {
            line = "true,System Accept";
        }
        System.out.println(lineb);
        return line;
    }

    public void listapps() {
        try {

            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cf apps");
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }

        } catch (Exception e) {
        }

    }

    public String uploadwar(String projectname, String path) {
        String lineb = "";
        String line;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cf push " + projectname + " -p " + path);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                lineb = lineb + line;
            }
            System.out.println("lineb = " + lineb);
        } catch (Exception e) {
        }
        return lineb;
    }

    public String SingleAppStatus(String statusname) {
        String lineb = "";
        String line;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "cf app " + statusname);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                lineb = lineb + line;
            }
            if (lineb.indexOf("not found") > -1) {
                lineb = "Not Found";
            } else {
                lineb = lineb.substring(lineb.indexOf("state:") - 6, lineb.indexOf("instance"));
                System.out.println("lineb = " + lineb);
            }
        } catch (Exception e) {
        }

        return lineb;
    }

    public String gotoWebPage() {
        String lineb = "";
        String line;
        try {
            ProcessBuilder builder = new ProcessBuilder(
                    "cmd.exe", "/c", "start http://yazilimkulubu.com/ ");

            builder.redirectErrorStream(true);
            Process p = builder.start();
            BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while (true) {
                line = r.readLine();
                if (line == null) {
                    break;
                }
                lineb = lineb + line;
            }
        } catch (Exception e) {
        }

        return lineb;
    }

}
