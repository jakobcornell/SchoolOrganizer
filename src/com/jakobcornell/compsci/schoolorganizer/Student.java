package com.jakobcornell.compsci.schoolorganizer;
import java.util.List;
import java.util.Map;


public class Student implements IStudent {
   private String name;
   private List<IClass[]> schedules;
   private Map<IClass, Grade> grades;
   
   public Student(String name) {
      this.name = name;
   }
   
   public void setName(String newName) {
      name = newName;
   }
   
   public IClass getClassAt(int semester, int block) throws EnrollmentException {
      return schedules.get(semester)[block];
   }
   
   public void enroll(int semester, int block, IClass cl) throws EnrollmentException {
      boolean isEnrolled = false;
      for (IClass[] schedule : schedules) {
         for (IClass testClass : schedule) {
            if (testClass == cl) {
               isEnrolled = true;
            }
         }
      }
      if (isEnrolled == false) {
         schedules.get(semester)[block] = cl;
      }
   }
   
   public void unenroll(IClass cl) throws EnrollmentException {
      for (IClass[] schedule : schedules) {
         for (IClass testClass : schedule) {
            if (cl == testClass) {
               
            }
         }
      }
   }
   
   public void assignGrade(IClass cl, Grade grade) throws EnrollmentException {
      // I'll get you, my pretty, and your little dog TODO too!
      
   }
   
   public Grade getGrade(IClass cl) throws EnrollmentException {
      return grades.get(cl);
   }
}
