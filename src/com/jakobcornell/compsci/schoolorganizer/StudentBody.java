package com.jakobcornell.compsci.schoolorganizer;

import java.util.HashSet;
import java.util.Set;

public class StudentBody implements IStudentBody {
   private Set<IStudent> students = new HashSet<IStudent>(); // creates a set of students and initializes it so that students can be added and removed
   
   public void addStudent(IStudent student) {
      students.add(student);
   }
   
   public void removeStudent(IStudent student) {
      students.remove(student);
   }
   
   /*
    * Returns a list of the students enrolled in cl
    */
   public Set<IStudent> getClassMembers(IClass cl) {
      Set<IStudent> classMembers = new HashSet<IStudent>();
      for (IStudent testStudent : students) {
         if (testStudent.isEnrolled(cl)) {
            classMembers.add(testStudent);
         }
      }
      return classMembers;
   }
   
   /*
    * Returns a list of all the students in the student body
    */
   public Set<IStudent> getAllStudents() {
      return students;
   }

}
