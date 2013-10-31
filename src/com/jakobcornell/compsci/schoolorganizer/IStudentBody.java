package com.jakobcornell.compsci.schoolorganizer;

import java.util.List;

public interface IStudentBody {
   
   public void addStudent(IStudent student);
   public void removeStudent(IStudent student);
   
   /*
   * Returns a list of the students enrolled in cl
   */
   public List<IStudent> getClassMembers(IClass cl);
   
   /*
   * Returns a list of all the students in the student body
   */
   public List<IStudent> getAllStudents();
   
}
