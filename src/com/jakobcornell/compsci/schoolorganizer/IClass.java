package com.jakobcornell.compsci.schoolorganizer;

import java.util.Date;

public interface IClass {

   /*
   * Returns whether date is in the class
   */
   public boolean contains(Date date);
   
   /*
   * Uses an input date, student, and boolean to modify the roll
   * Throws EnrollmentException when date is not in the class
   */
   public void setAttendance(Date date, IStudent student, boolean wasPresent) throws EnrollmentException;
   
   /*
   * Returns whether student was present on date
   * Throws EnrollmentException when date is not in the class
   */
   public boolean wasPresent(Date date, IStudent student) throws EnrollmentException;

}
