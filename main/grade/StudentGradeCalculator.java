package com.example.grade;
public class StudentGradeCalculator 
{
  List<Integer> marks= new ArrayList<>();
  public void addMarks(int marks)
  {
  if(marks<0)
   throw new IllegalArgumentException("Marks cannot be negative..");
  else
   this.marks.add(marks);   
   }
  public double calculateAverage()
  {
    if(this.marks.isEmpty())
    {
      throw new IllegalStateException("No marks added");
    }
    int sum=0;
    for(int m:marks)
    {
     sum+=m;
    }
    return (double)sum/marks.size(); 
  }
  public String getResult() 
  {
     double avg=calculateAverage();
     return (avg>=40)?"PASS":"FAIL";
  }
}