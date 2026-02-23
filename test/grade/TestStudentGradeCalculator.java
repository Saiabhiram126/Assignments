package com.example.grade;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class TestStudentGradeCalculator 
{
  //1. Verify that average is calculated correctly for multiple marks. 
  @Test
  public void testCalcualteAverageForMultipleMarks()
  {
  StudentGradeCalculator ref= new StudentGradeCalculator();
  ref.addMarks(70);
  ref.addMarks(70);
  ref.addMarks(70);
  ref.addMarks(70);
  double avg=ref.calculateAverage(); // actual
  assertEquals(70,avg);
  }
  //2. Ensure "PASS" is returned when average ≥ 40.  
  @Test
  public void testPassResult()
  {
  StudentGradeCalculator ref= new StudentGradeCalculator();
  ref.addMarks(40);
  ref.addMarks(40);
  double avg=ref.calculateAverage();
  assertEquals("PASS",ref.getResult());
  }
  //3. Ensure "FAIL" is returned when average < 40.  
  @Test
  public void testFailResult()
  {
  StudentGradeCalculator ref= new StudentGradeCalculator();
  ref.addMarks(30);
  ref.addMarks(35);
  double avg=ref.calculateAverage(); 
  assertEquals("FAIL",ref.getResult());
  }
//4.Check that adding negative marks throws an exception. 
  @Test 
  public void testNegativeMarksThrowsException()
  {
  StudentGradeCalculator ref= new StudentGradeCalculator();
    assertThrows(IllegalArgumentException.class,()->{ref.addMarks(-30);});
  }
  //5. Verify behavior when no marks are added.
  @Test
  public void testNoMarksAddedThrowsException()
  {
  StudentGradeCalculator ref= new StudentGradeCalculator();  
  assertThrows(IllegalStateException.class,ref::calculateAverage); 
  }
}

 