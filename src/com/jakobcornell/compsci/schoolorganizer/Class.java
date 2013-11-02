package com.jakobcornell.compsci.schoolorganizer;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Class implements IClass {
   private final String name;
   private Set<Date> sessions;
   private Map<Date, Set<IStudent>> attendance; // used to associate a date with a set of students (who were present)

   public Class(String name) {
      this.name = name;
      sessions = new HashSet<Date>();
      attendance = new HashMap<Date, Set<IStudent>>();
   }
   
   /*
    * Returns a string to use to represent the class (for the interface)
    */
   public String toString() {
      return name;
   }
   
   /*
    * Returns whether date is within the class's date range
    */
   public boolean contains(Date date) {
      return sessions.contains(date);
   }
   
   /*
    * Adds a date when the class met
    */
   public void addSession(Date session) {
      sessions.add(session);
   }
   
   /*
    * Removes a date when the class met
    */
   public void removeSession(Date session) {
      sessions.remove(session);
   }
   
   /*
    * Gets the set of dates when the class met
    */
   public Set<Date> getSessions() {
      return sessions;
   }
   
   /*
    * Uses an input date, student, and boolean to modify the roll
    * Throws EnrollmentException when date is not within the class's date range
    */
   public void setAttendance(Date date, IStudent student, boolean wasPresent) throws EnrollmentException {
      if (contains(date) == false)
         throw new EnrollmentException();
      if (attendance.get(date) == null)
         attendance.put(date, new HashSet<IStudent>());
      if (wasPresent)
         attendance.get(date).add(student);
      else
         attendance.get(date).remove(student);
   }
   
   /*
    * Returns whether student was present on date
    * Throws EnrollmentException when date is not within the class's date range
    */
   public boolean wasPresent(Date date, IStudent student) throws EnrollmentException {
      if (contains(date) == false)
         throw new EnrollmentException();
      if (attendance.get(date) == null)
         return false;
      else
         return attendance.get(date).contains(student);
   }
   
   public String getName() {
      return name;
   }
}
