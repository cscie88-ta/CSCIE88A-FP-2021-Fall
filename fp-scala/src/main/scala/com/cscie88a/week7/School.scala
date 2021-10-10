package com.cscie88a.week7

object School {
    final case class Student(
      id: String,
      fistName: String,
      lastName: String,
      email: String,
      gender: String,
      country: String
  )

  final case class Subject(
      id: String,
      name: String
  )

  final case class Enrollment(
      studentId: String,
      subjectId: String
  )

  // TODO complete the list of students from homework problem
  val studentList = List(
    Student("1", "Emmy", "Conrart", "econrart0@gizmodo.com", "Male", "China"),
    Student("2","Marin","Blasoni","mblasoni1@edublogs.org","Female","United States")
  )

  val subjectList = List(
    Subject("1", "Physics"),
    Subject("2", "Chemistry"),
    Subject("3", "Math"),
    Subject("4", "English")
  )

  // TODO complete the list of enrollments from homework problem
  val enrollmentList = List(
    Enrollment("1", "1"),
    Enrollment("1", "2"),
    Enrollment("2", "1")
  )

  def studentBySubjectRows(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): List[(Subject, Student)] = ???

  def studentsBySubject(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): Map[Subject, List[Student]] = ???

  def classSizeBySubject(
      students: List[Student],
      subjects: List[Subject],
      enr: List[Enrollment]
  ): Map[Subject, Int] = ???

}
