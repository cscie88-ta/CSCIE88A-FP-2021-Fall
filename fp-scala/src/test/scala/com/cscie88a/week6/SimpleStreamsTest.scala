package com.cscie88a.week6
import com.cscie88a.testutils.StandardTest

class SimpleStreamsTest extends StandardTest {
  
  "Streams" when {

    "creating an instance" should {

      "create a finite stream of multiples of 5" in {
        true shouldBe false
      }

      "create an infinite stream of random integers between 0 and 15" in {
        true shouldBe false
      }

      "create an infinite stream of dogs" in {
        true shouldBe false
      }
    }

    "using map, filter, reduce, and reduce operations" should {

      "return a stream of healthy dogs for function healthyDogs" in {
        true shouldBe false
      }

      "return the average age of healthy dogs for a sample size for function averageHealthyAge" in {
        true shouldBe false
      }
    }

    "using partition and zip operations" should {

      "return two streams of dogs partitioned by health status for function dogsByHealthStatus" in {
        true shouldBe false
      }

      "return a stream of pairs of healthy and unhealthy dogs for function pairHealthyUnhealthyDogs" in {
        true shouldBe false
      }
    }

    "using data pipelines" should {

      "return a stream of the oldest dog in every 5 samples for function oldestDogs" in {
        true shouldBe false
      }
    }

    "using for comprehensions" should {

      "return true only if a triplet of integers (a,b,c) satisfies the equation, a^2 + b^2 = c^2, for function pythTest" in {
        true shouldBe false
      }

      "create a stream of pythogorean triplets" in {
        true shouldBe false
      }
    }

  }
}
