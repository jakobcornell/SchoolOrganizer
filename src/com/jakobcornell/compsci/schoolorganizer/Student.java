package com.jakobcornell.compsci.schoolorganizer;

import java.util.Map;
import java.util.HashMap;

public class Student implements IStudent {
   private String name;
   private Map<Integer, IClass[]> schedules; // associates an integer with an array of classes (one array per semester, 4 classes per array)
   private Map<IClass, Grade> grades; // associates a grade with a class
   
   public Student(String name) {
      this.name = name;
      schedules = new HashMap<Integer, IClass[]>();
      grades = new HashMap<IClass, Grade>();
   }
   
   public void setName(String newName) {
      name = newName;
   }
   
   public String getName() {
      return name;
   }
   
   /*
    * Returns the class the student has in a given semester and block
    * Throws EnrollmentException when block is greater than 3
    */
   public IClass getClassAt(int semester, int block) throws EnrollmentException {
      if (block > 3)
         throw new EnrollmentException();
      if (schedules.get(semester) == null)
         return null;
      else
         return schedules.get(semester)[block];
   }
   
   /*
    * Adds a class to the student's schedule
    * Throws EnrollmentException when block is greater than three, the student is already enrolled in the class, or the student is enrolled in another class at the specified semester and block
    */
   public void enroll(int semester, int block, IClass cl) throws EnrollmentException {
      if (block > 3)
         throw new EnrollmentException();
      if (isEnrolled(cl))
         throw new EnrollmentException();
      if (getClassAt(semester, block) != null)
         throw new EnrollmentException();
      if (schedules.get(semester) == null)
         schedules.put(semester, new IClass[4]);
      schedules.get(semester)[block] = cl;
   }
   
   /*
    * Removes the input class from the student's schedule
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public void unenroll(IClass cl) throws EnrollmentException {
      boolean isEnrolled = false;
      for (IClass[] schedule : schedules.values()) {
         for (int iter = 0; iter < schedule.length; iter ++) {
            if (schedule[iter] == cl) {
               isEnrolled = true;
               schedule[iter] = null;
            }
         }
      }
      if (isEnrolled == false) {
         throw new EnrollmentException();
      }
   }
   
   /*
    * Tests whether the student is enrolled in cl
    */
   public boolean isEnrolled(IClass cl) {
      boolean isEnrolled = false;
      for (IClass[] schedule : schedules.values()) {
         for (IClass testClass : schedule) {
            if (testClass == cl) {
               isEnrolled = true;
            }
         }
      }
      return isEnrolled;
   }
   
   /*
    * Assigns an input letter grade to an input class in which the student is enrolled
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public void assignGrade(IClass cl, Grade grade) throws EnrollmentException {
      if (isEnrolled(cl))
         grades.put(cl, grade);
      else
         throw new EnrollmentException();
   }
   
   /*
    * Returns the grade the student has in the input class
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public Grade getGrade(IClass cl) throws EnrollmentException {
      if (isEnrolled(cl))
         return grades.get(cl);
      else {
         throw new EnrollmentException();
      }
   }
}
