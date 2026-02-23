package com.example.grade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

 

import org.junit.jupiter.api.Test;
public class TestMultiStudentGradeManager 
{
  //1.Verify that multiple students can be added and managed independently.
  @Test 
  public void testMultipleStudentsManagedIndependently()
  {
   MultiStudentGradeManager mgr= new MultiStudentGradeManager();
   mgr.addStudent("Amit");
   mgr.addStudent("Sumit");
   mgr.addMarks("Amit",70);
   mgr.addMarks("Sumit",90);
   assertEquals(70,mgr.calculateAverage("Amit"));
   assertEquals(90,mgr.calculateAverage("Sumit"));
  }
//2.Ensure averages are calculated correctly per student.
  @Test 
  public void testCalculateAveragePerStduent()
  {
   MultiStudentGradeManager mgr= new MultiStudentGradeManager();
   mgr.addStudent("Amit");
   mgr.addStudent("Sumit");
   mgr.addMarks("Amit",70);
   mgr.addMarks("Amit",80);
   mgr.addMarks("Amit",90);  
   assertEquals(80,mgr.calculateAverage("Amit")); 
  }


//3.Confirm that getResult() works correctly for each student.
  @Test 
  public void testGetResultEachStudent()
  {
   MultiStudentGradeManager mgr= new MultiStudentGradeManager();
   mgr.addStudent("Amit");
   mgr.addStudent("Sumit");
   mgr.addMarks("Amit",39);
   mgr.addMarks("Sumit",90);
   assertEquals("FAIL",mgr.getResult("Amit"));
   assertEquals("PASS",mgr.getResult("Sumit"));
  }
  //4.Check that adding marks to a non-existent student throws an exception.
  @Test 
  public void testNonexistentStudentThrowsexception()
  {
   MultiStudentGradeManager mgr= new MultiStudentGradeManager();
   assertThrows(IllegalArgumentException.class,()->{ mgr.addMarks("Ajit",39);});       
  }

//5.Verify that getTopper() returns the correct student when multiple students exist.
  @Test 
  public void testGetTopperStudentFromMultiple()
  {
   MultiStudentGradeManager mgr= new MultiStudentGradeManager();
   mgr.addStudent("Amit");
   mgr.addStudent("Sumit");
   mgr.addMarks("Amit",39);
   mgr.addMarks("Sumit",90);
   assertEquals("Sumit", mgr.getTopper());
  }

//6.Ensure behavior when no students are added.
  public void testNoStudentsAddedThrowsException()
  { 
    MultiStudentGradeManager mgr= new MultiStudentGradeManager();
    assertThrows(IllegalStateException.class,mgr::getTopper);
  }  
}

 