import com.yyan.App;
import com.yyan.dao.DepartmentDao;
import com.yyan.pojo.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class})
public class TestDepartment {

    @Autowired
    private DepartmentDao departmentDao;


    @Test
    public void departInitTest() {

        departmentDao.insertDepartment(new Department("1", "研发部门", "0"));
        departmentDao.insertDepartment(new Department("2", "研发团队1", "1"));
        departmentDao.insertDepartment(new Department("3", "研发团队2", "1"));
        departmentDao.insertDepartment(new Department("4", "财务部门", "0"));
        departmentDao.insertDepartment(new Department("5", "财务A部门", "4"));
        departmentDao.insertDepartment(new Department("6", "财务B部门", "4"));
        departmentDao.insertDepartment(new Department("7", "财务A部门团队1", "5"));
        departmentDao.insertDepartment(new Department("8", "财务A部门团队2", "5"));
        departmentDao.insertDepartment(new Department("9", "财务B部门团队1", "6"));
        departmentDao.insertDepartment(new Department("10", "财务B部门团队2", "6"));
        departmentDao.insertDepartment(new Department("11", "财务B部门团队3", "6"));
        departmentDao.insertDepartment(new Department("12", "财务B部门团队4", "6"));
        departmentDao.insertDepartment(new Department("13", "财务B部门团队5", "6"));
        departmentDao.insertDepartment(new Department("14", "财务B部门团队6", "6"));
        departmentDao.insertDepartment(new Department("15", "财务B部门团队7", "6"));
        departmentDao.insertDepartment(new Department("16", "财务B部门团队8", "6"));
        departmentDao.insertDepartment(new Department("17", "财务B部门团队9", "6"));
        departmentDao.insertDepartment(new Department("18", "财务B部门团队10", "6"));


    }
}
