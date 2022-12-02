package com.techelevator.projects.dao;

import com.techelevator.projects.model.Timesheet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

public class JdbcTimesheetDaoTests extends BaseDaoTests {

    private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    private static final Timesheet TIMESHEET_2 = new Timesheet(2, 1, 1,
            LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    private static final Timesheet TIMESHEET_3 = new Timesheet(3, 2, 1,
            LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    private static final Timesheet TIMESHEET_4 = new Timesheet(4, 2, 2,
            LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");

    private static final List<Timesheet> TIMESHEETS = List.of(TIMESHEET_1, TIMESHEET_2, TIMESHEET_3, TIMESHEET_4);
    private static final List<Timesheet> EMPLOYEE_1_TIMESHEETS = List.of(TIMESHEET_1, TIMESHEET_2);
    private static final List<Timesheet> EMPLOYEE_2_TIMESHEETS = List.of(TIMESHEET_3, TIMESHEET_4);
    private static final List<Timesheet> PROJECT_1_TIMESHEETS = List.of(TIMESHEET_1, TIMESHEET_2, TIMESHEET_3);
    private static final List<Timesheet> PROJECT_2_TIMESHEETS = List.of(TIMESHEET_4);

    private Timesheet newTimesheet;

    private JdbcTimesheetDao dao;


    @Before
    public void setup() {
        dao = new JdbcTimesheetDao(dataSource);
        newTimesheet = new Timesheet(5, 1, 2, LocalDate.parse("2021-02-02"), 5.5, true, "Test Timesheet 5");
    }

    @Test
    public void getTimesheet_returns_correct_timesheet_for_id() {

        for (Timesheet expected : TIMESHEETS){

            //arrange
            int timesheetId = expected.getTimesheetId();

            //act
            Timesheet actual = dao.getTimesheet(timesheetId);

            //assert
            String message = "Because I searched for timesheet id: " + timesheetId;
            assertTimesheetsMatch(message, expected, actual);
        }
    }


    @Test
    public void getTimesheet_returns_null_when_id_not_found() {

        //arrange
        int timesheetId = 42;

        //act
        Timesheet actual = dao.getTimesheet(42);

        //assert
        String message = "Because there should be no timesheet with timesheet_id=42 in the database.";
        Assert.assertNull(message, actual);

    }

    @Test
    public void getTimesheetsByEmployeeId_returns_list_of_all_timesheets_for_employee() {

        //arrange
        int employeeId = 1;
        List<Timesheet> expected = EMPLOYEE_1_TIMESHEETS;

        //act
        List<Timesheet> actual = dao.getTimesheetsByEmployeeId(employeeId);

        //assert
        String message = "Because employee 1 should have 2 timesheets";
        Assert.assertEquals(message, expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++){
            message = "timesheets in list at index " + i + " should match, given employee 1";
            assertTimesheetsMatch(message, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void getTimesheetsByProjectId_returns_list_of_all_timesheets_for_project() {

        //arrange
        int projectId = 1;
        List<Timesheet> expected = PROJECT_1_TIMESHEETS;

        //act
        List<Timesheet> actual = dao.getTimesheetsByProjectId(projectId);

        //assert
        String message = "Because project 1 should have 3 timesheets";
        Assert.assertEquals(message, expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            message = "timesheets in list at index " + i + " should match, given project 1";
            assertTimesheetsMatch(message, expected.get(i), actual.get(i));
        }
    }

    @Test
    public void createTimesheet_returns_timesheet_with_id_and_expected_values() {

        //arrange

        //act
        Timesheet testTimesheet = dao.createTimesheet(newTimesheet);

        //assert
        int newID = testTimesheet.getTimesheetId();
        String message="Because a new ID should be generated and returned from the DAO";
        boolean is5 = (newID == 5);
        Assert.assertTrue(message, is5);

        testTimesheet.setTimesheetId(newID);
        message = "Because the object returned from the DAO should have the provided values";
        assertTimesheetsMatch(message, newTimesheet, testTimesheet);
    }

    @Test
    public void created_timesheet_has_expected_values_when_retrieved() {

        //arrange

        //act
        Timesheet testTimesheet = dao.createTimesheet(newTimesheet);

        //assert
        int newId = testTimesheet.getTimesheetId();
        Timesheet fetchedTimesheet = dao.getTimesheet(newId);

        String message = "Because the newly created timesheet should have the correct values in the database.";
        assertTimesheetsMatch(message, testTimesheet, fetchedTimesheet);
    }

    @Test
    public void updated_timesheet_has_expected_values_when_retrieved() {
        /*
            private static final Timesheet TIMESHEET_1 = new Timesheet(1, 1, 1,
            LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
         */

        //arrange
        int timesheetId = 1;
        Timesheet timesheetToUpdate = dao.getTimesheet(timesheetId);

        timesheetToUpdate.setEmployeeId(2);                             // employee id: 1 -> 2;
        timesheetToUpdate.setProjectId(2);                             // project id: 1 -> 2;
        timesheetToUpdate.setDateWorked(LocalDate.parse("2021-03-03")); // date worked: 2021-01-01 -> 2021-03-03
        timesheetToUpdate.setHoursWorked(3);                            // hours worked: 1 -> 3
        timesheetToUpdate.setBillable(false);                           // billable: true -> false
        timesheetToUpdate.setDescription("Timesheet One");              // description: "Timesheet 1" -> "Timesheet One"

        //act
        dao.updateTimesheet(timesheetToUpdate);

        //assert
        Timesheet fetchedTimesheet = dao.getTimesheet(timesheetId);
        String message = "Because the updated timesheet should reflect the updated values in the database.";
        assertTimesheetsMatch(message, timesheetToUpdate, fetchedTimesheet);
    }

    @Test
    public void deleted_timesheet_cant_be_retrieved() {

        //arrange
        int deleteId = 1;

        //act
        dao.deleteTimesheet(deleteId);

        //assert
        Timesheet fetchedTimesheet = dao.getTimesheet(deleteId);
        String message = "Because the timesheet should be deleted from the database.";
        Assert.assertNull(message, fetchedTimesheet);
    }

    /*
    (timesheet_id, employee_id, project_id, date_worked, hours_worked, billable, description)
    TIMESHEET_1 = (1, 1, 1, LocalDate.parse("2021-01-01"), 1.0, true, "Timesheet 1");
    TIMESHEET_2 = (2, 1, 1, LocalDate.parse("2021-01-02"), 1.5, true, "Timesheet 2");
    TIMESHEET_3 = (3, 2, 1, LocalDate.parse("2021-01-01"), 0.25, true, "Timesheet 3");
    TIMESHEET_4 = (4, 2, 2, LocalDate.parse("2021-02-01"), 2.0, false, "Timesheet 4");
     */

    @Test
    public void getBillableHours_returns_correct_total() {

        //arrange
        double expectedHours = 2.5;
        double noExpectedHours = 0;

        //act
        double actualHours = dao.getBillableHours(1, 1);
        double noActualHours = dao.getBillableHours(2, 2);

        //assert
        String message = "Because employee 1, project 1, billable is (1 + 1.5) hours";
        Assert.assertTrue(message, expectedHours == actualHours);
        String message2 = "Because employee 2, project 2, NOT billable is 0";
        Assert.assertTrue(message2, noExpectedHours == noActualHours);

    }

    private void assertTimesheetsMatch(String message, Timesheet expected, Timesheet actual) {
        Assert.assertEquals(message, expected.getTimesheetId(), actual.getTimesheetId());
        Assert.assertEquals(message, expected.getEmployeeId(), actual.getEmployeeId());
        Assert.assertEquals(message, expected.getProjectId(), actual.getProjectId());
        Assert.assertEquals(message, expected.getDateWorked(), actual.getDateWorked());
        Assert.assertEquals(message, expected.getHoursWorked(), actual.getHoursWorked(), 0.001);
        Assert.assertEquals(message, expected.isBillable(), actual.isBillable());
        Assert.assertEquals(message, expected.getDescription(), actual.getDescription());
    }

}
