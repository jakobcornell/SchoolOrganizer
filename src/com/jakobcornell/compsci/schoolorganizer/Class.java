package com.jakobcornell.compsci.schoolorganizer;

import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Class implements IClass {
   private final String name;
   private final Date start, end;
   private Map<Date, Set<IStudent>> attendance; // used to associate a date with a set of students (who were present)

   public Class(String name, Date start, Date end) {
      this.name = name;
      this.start = start;
      this.end = end;
      attendance = new HashMap<Date, Set<IStudent>>();
   }
   
   /*
    * Returns whether date is within the class's date range
    */
   public boolean contains(Date date) {
      if (date.after(start) && date.before(end))
         return true;
      else {
         return false;
      }
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
   
   public Date getStartDate() {
      return start;
   }
   
   public Date getEndDate() {
      return end;
   }
}
