package com.jakobcornell.compsci.schoolorganizer;

import java.util.Date;
import java.util.Set;

public interface IClass {
   
   /*
    * Returns whether the class met on date
    */
   public boolean contains(Date date);
   
   /*
    * Adds a date when the class met
    */
   public void addSession(Date session);
   
   /*
    * Removes a date when the class met
    */
   public void removeSession(Date session);
   
   /*
    * Gets the set of dates when the class met
    */
   public Set<Date> getSessions();
   
   /*
    * Uses an input date, student, and boolean to modify the roll
    * Throws EnrollmentException when the class did not meet on date
    */
   public void setAttendance(Date session, IStudent student, boolean wasPresent) throws EnrollmentException;
   
   /*
    * Returns whether student was present on date
    * Throws EnrollmentException when the class did not meet on date
    */
   public boolean wasPresent(Date session, IStudent student) throws EnrollmentException;
   
   public String getName();
}
