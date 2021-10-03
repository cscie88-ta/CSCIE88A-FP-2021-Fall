package com.cscie88a.week6

import java.util.UUID
import scala.util.Random

object SimpleStreams {

  // string uuid generator
  def uuid = UUID.randomUUID().toString().replaceAll("-", "")
  // random generator
  val rnd = new Random()

  val mult5: Stream[Int] = ???
  val randomAge: Stream[Int] = ???
  val allDogs: Stream[Dog] = ???
  
  def healthyDogs(dogs: Stream[Dog]): Stream[Dog] = ???
  def averageHealthyAge(dogs: Stream[Dog], sampleSize: Int): Double = ???
  def dogsByHealthStatus(dogs: Stream[Dog]): (Stream[Dog], Stream[Dog]) = ???
  def pairHealthyUnhealthyDogs(dogs: Stream[Dog]): Stream[(Dog, Dog)] = ???
  def oldestDogs(dogs: Stream[Dog]): Stream[Dog] = ???

  def pythTest(triplet: Tuple3[Int, Int, Int]): Boolean = ???
  val upto100: Stream[Int] = ???
  val pythTriples: Stream[Tuple3[Int, Int, Int]] = ???

}
