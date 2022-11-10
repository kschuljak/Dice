**Unit Tests**: many & fast   
**Integration Tests**   
**End-to-End Tests**: few & slow   

**Code Coverage**:   
- 100% code coverage should be the goal   
- should have more unit tests than code being tested   
- test edge cases, bad input, etc. - try to anticipate user error   

Traditional Software Development LifeCycle:
- REQUIREMENTS   
- DESIGN   
- CODE **<- should be testing while coding**    
- TEST  *(if you wait until later to test, it will be harder and take longer to find and fix bugs)*    
- DEPLOY   

Better approach is:   
- REQUIREMENTS   
  - *NEVER* assume, *ALWAYS* get clarification from product owner 
- DESIGN **AND** CODE **AND** TEST  *(agile method)*   
  - write tests, write code, test code, repeat *(sprints)*
- FINAL TESTING   
- DEPLOY   
   
---
   
Creating a Unit Test:
- right click name (of class, method, etc)
- insert 'test' (JUnit4)
- should create 'nameTest.java' in 'test' folder
- tests must be `public`, `void`, and not take input parameters

```java
public class ClassTest {
    
    @Test
    public void testClass_MethodName_StateUnderTest_ExpectedBehavior(){
        // test names should be descriptive
        // make obvious what is being tested, and what is failing
        
        // ... test method body here
        
        // 1 - ARRANGE -- setup
        
        // 2 - ACT -- the (ONE) thing you are testing
        
        // 3 - ASSERT -- statement about expected value - because why?
    }
    
}
```
```java
// example of good test naming convention - meaningful names
public class CowTest {
    @Test
    public void getSound_Should_beMoo_AfterCreation() {

        // arrange - setup required for test
        String expected = "moo!";
        Cow cow = new Cow();

        // act - method being tested
        String actual = cow.getSound();

        // assert - (because statement, expected value, actual value)
        assertEquals("because Cow should say moo after instantiation", expected, actual);
    }
}
```
*(Make sure all your tests are passing before you check in code!)*
