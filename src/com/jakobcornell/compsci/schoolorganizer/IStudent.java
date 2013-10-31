package com.jakobcornell.compsci.schoolorganizer;

public interface IStudent {
   
   /*
   * Modifies the name of the student based on a string input
   */
   public void setName(String newName);
   
   /*
   * Returns the class the student has in a given semester and block
   * Throws EnrollmentException when semester is negative or block is less than 0 or greater than 3
   */
   public IClass getClassAt(int semester, int block) throws EnrollmentException;
   
   /*
   * Adds a class to the student's schedule
   * Throws EnrollmentException when semester is negative or block is less than 0 or greater than 3 or cl is null
   */
   public void enroll(int semester, int block, IClass cl) throws EnrollmentException;
   
   /*
   * Removes the input class from the student's schedule
   * Throws EnrollmentException when cl is null or the student is not enrolled in cl
   */
   public void unenroll(IClass cl) throws EnrollmentException;

   /*
   * Assigns an input letter grade to an input class in which the student is enrolled
   * Throws EnrollmentException when cl is null or the student is not enrolled in cl
   */
   public void assignGrade(IClass cl, Grade grade) throws EnrollmentException;
   
   /*
   * Returns the grade the student has in the input class
   * Throws EnrollmentException when cl is null or the student is not enrolled in cl
   */
   public Grade getGrade(IClass cl) throws EnrollmentException;
   
}
