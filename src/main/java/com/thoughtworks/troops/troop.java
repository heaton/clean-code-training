package com.thoughtworks.troops;

import java.util.ArrayList;
import java.util.Collections;

public class troop extends MemberList {
    String number;

    public troop(String troopNumber) {
        this.number = troopNumber;
        memberList = new ArrayList<Member>();
    }

    public void addScout(String name, int position, int rank) {
        Member newmem = Member.createMember(name, position, 0, rank);
        this.memberList.add(newmem);
    }

    public void addAdult(String name, int position) {
        Member newmem = new Member(name, position, 1);
        this.memberList.add(newmem);
    }

    public String getTroopNum() {
        return this.number;
    }

    public String scoutsAdultsReport() {
        String reportString;

        reportString = "Adult members of Troop " + number + TroopConstants.NEWLINE;
        Collections.sort(memberList);
        // First write out the Adult leaders
        for (Member memberToWrite : memberList) {
            // Check if you have an adult
            if (memberToWrite.getType() == 1) {
                // write the name first
                reportString += "  " + memberToWrite.getName() + " -  Adult, Position = ";
                reportString = getAdultsPositionString(reportString,
                        memberToWrite);
            }  // end if
        } // end for

        // now add the Boy scouts
        reportString += "Scout members of Troop " + number + TroopConstants.NEWLINE;
        for (Member memberToWrite : memberList) {
            if (memberToWrite.getType() == 0) {
                reportString += "  " + memberToWrite.getName() + " - Boyscout, Position = ";
                reportString = scoutPositionString(reportString, memberToWrite);

                reportString += ", Rank = ";
                reportString = scoutRankString(reportString, memberToWrite);
                reportString += TroopConstants.NEWLINE;
            } // end if
        } // end for
        return reportString;
    } // end method

    private String scoutRankString(String reportString, Member memberToWrite) {
        switch (memberToWrite.getRank()) {
            case (TroopConstants.SCOUT):
                reportString += "Scout";
                break;
            case (TroopConstants.TENDERFOOT):
                reportString += "Tenderfoot";
                break;
            case (TroopConstants.SECOND_CLASS):
                reportString += "Second Class";
                break;
            case (TroopConstants.FIRST_CLASS):
                reportString += "First Class";
                break;
            case (TroopConstants.STAR):
                reportString += "Star";
                break;
            case (TroopConstants.LIFE):
                reportString += "Life";
                break;
            case (TroopConstants.EAGLE):
                reportString += "Eagle";
                break;
            default:
                reportString += "null";
        }
        return reportString;
    }

    private String scoutPositionString(String reportString, Member memberToWrite) {
        switch (memberToWrite.getPosition()) {
            case (TroopConstants.SPL):
                reportString += "Senior Patrol Leader";
                break;
            case (TroopConstants.ASPL):
                reportString += "Assistant Senior Patrol Leader";
                break;
            case (TroopConstants.HISTORIAN):
                reportString += "Historian";
                break;
            case (TroopConstants.LIBRARIAN):
                reportString += "Librarian";
                break;
            case (TroopConstants.BUGLER):
                reportString += "Bugler";
                break;
            case (TroopConstants.SCRIBE):
                reportString += "Scribe";
                break;
            default:
                reportString += "null";
        }
        return reportString;
    }

    private String getAdultsPositionString(String reportString,
                                           Member memberToWrite) {
        // now write the position
        switch (memberToWrite.getPosition()) {
            case (TroopConstants.COMMITTEE_MEMBER):
                reportString += "Committee Member";
                break;
            case (TroopConstants.SCOUTMASTER):
                reportString += "Scoutmaster";
                break;
            case (TroopConstants.COMMITTEE_CHAIR):
                reportString += "Committee Chair";
                break;
            case (TroopConstants.ASST_SCOUTMASTER):
                reportString += "Assistant Scoutmaster";
                break;
            default:
                reportString += "null";
        }
        reportString += (TroopConstants.NEWLINE);
        return reportString;
    }

    public String allReport() {
        String reportString;

        reportString = "All members of Troop " + number + TroopConstants.NEWLINE;
        Collections.sort(memberList);
        for (Member memberToWrite : memberList) {
            // write the name first
            reportString += "  " + memberToWrite.getName();
            // Process adults differently
            if (memberToWrite.getType() == 1) {
                reportString += " - Adult, Position = ";
                // now write the position
                switch (memberToWrite.getPosition()) {
                    case (TroopConstants.COMMITTEE_MEMBER):
                        reportString += "Committee Member";
                        break;
                    case (TroopConstants.SCOUTMASTER):
                        reportString += "Scoutmaster";
                        break;
                    case (TroopConstants.COMMITTEE_CHAIR):
                        reportString += "Committee Chair";
                        break;
                    case (TroopConstants.ASST_SCOUTMASTER):
                        reportString += "Assistant Scoutmaster";
                        break;
                    default:
                        reportString += "null";
                }
            } // end if adult
            else {  // we have a boyscout
                reportString += " - Boyscout, Position = ";
                switch (memberToWrite.getPosition()) {
                    case (TroopConstants.SPL):
                        reportString += "Senior Patrol Leader";
                        break;
                    case (TroopConstants.ASPL):
                        reportString += "Assistant Senior Patrol Leader";
                        break;
                    case (TroopConstants.HISTORIAN):
                        reportString += "Historian";
                        break;
                    case (TroopConstants.LIBRARIAN):
                        reportString += "Librarian";
                        break;
                    case (TroopConstants.BUGLER):
                        reportString += "Bugler";
                        break;
                    case (TroopConstants.SCRIBE):
                        reportString += "Scribe";
                        break;
                    default:
                        reportString += "null";
                } // end position case
                reportString += ", Rank = ";
                switch (memberToWrite.getRank()) {
                    case (0):
                        reportString += "Scout";
                        break;
                    case (1):
                        reportString += "Tenderfoot";
                        break;
                    case (2):
                        reportString += "Second Class";
                        break;
                    case (3):
                        reportString += "First Class";
                        break;
                    case (4):
                        reportString += "Star";
                        break;
                    case (5):
                        reportString += "Life";
                        break;
                    case (6):
                        reportString += "Eagle";
                        break;
                    default:
                        reportString += "null";
                }
            } // end else
            reportString += TroopConstants.NEWLINE;
        } // end for
        return reportString;
    } // end method


}
