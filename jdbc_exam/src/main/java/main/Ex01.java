package main;

import configs.AppCtx;
import meodels.emp.Emp;
import meodels.emp.EmpDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

        EmpDao empDao = ctx.getBean(EmpDao.class);
        Emp emp = ctx.getBean(Emp.class);


        /** DB EMP2 추가 S */
//        emp.setENAME("직원");
//        emp.setJOB("STAFF");
//        long EMPNO = empDao.insert(emp);
//        System.out.println(EMPNO);
        /** DB EMP2 추가 E */

        /** DB EMP2 삭제 S */
//        emp.setEMPNO(5L);
//        empDao.delete(emp);
        /** DB EMP2 삭제 E */

        /** DB EMP2 전부 조회  S */
//        List<Emp> empGets = empDao.gets();
//        empGets.stream().forEach(System.out::println);
        /** DB EMP2 전부 조회  E */

        /** DB EMP2 ENAME 수정 S*/
//        emp.setEMPNO(6L);
//        emp.setENAME("직원2");
//        emp.setJOB("STAFF");
//        empDao.setName(emp);
        /** DB EMP2 ENAME 수정  E */

        /** DB EMP2 JOB 수정 S*/
//        emp.setEMPNO(6L);
//        emp.setJOB("MANAGER");
//        emp.setENAME("직원");
//        empDao.setJob(emp);
        /** DB EMP2 JOB 수정  E */

        ctx.close();
    }
}
