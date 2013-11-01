package com.jakobcornell.compsci.schoolorganizer;

public interface IStudent {
   public void setName(String newName);
   
   public String getName();
   
   /*
    * Returns the class the student has in a given semester and block
    * Throws EnrollmentException when block is greater than 3
    */
   public IClass getClassAt(int semester, int block) throws EnrollmentException;
   
   /*
    * Adds a class to the student's schedule
    * Throws EnrollmentException when block is greater than three, the student is already enrolled in the class, or the student is enrolled in another class at the specified semester and block
    */
   public void enroll(int semester, int block, IClass cl) throws EnrollmentException;
   
   /*
    * Removes the input class from the student's schedule
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public void unenroll(IClass cl) throws EnrollmentException;
   
   /*
    * Tests whether the student is enrolled in cl
    */
   public boolean isEnrolled(IClass cl);

   /*
    * Assigns an input letter grade to an input class in which the student is enrolled
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public void assignGrade(IClass cl, Grade grade) throws EnrollmentException;
   
   /*
    * Returns the grade the student has in the input class
    * Throws EnrollmentException if the student is not enrolled in cl
    */
   public Grade getGrade(IClass cl) throws EnrollmentException;
   
}
