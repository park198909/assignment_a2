package meodels.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Transactional
public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public long insert(Emp emp) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (EMP_SEQ.nextval, ?, ?)";
         jdbcTemplate.update((con)->{
                                     PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"EMPNO"});
                                     pstmt.setString(1,emp.getENAME());
                                     pstmt.setString(2, emp.getJOB());

                                     return pstmt;
                             },keyHolder);
         Number key = keyHolder.getKey();
         long EMPNO = key.longValue();

        return EMPNO;
    }

    public void delete(Emp emp) {
        String sql = "DELETE FROM EMP2 WHERE EMPNO=?";
        jdbcTemplate.update((con) ->{
           PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.setLong(1, emp.getEMPNO());

           return pstmt;
        });
    }

    public List<Emp> gets() {
        String sql = "SELECT * FROM EMP2";
        List<Emp> emp = jdbcTemplate.query((con) ->{
           PreparedStatement pstmt = con.prepareStatement(sql);
           return pstmt;
        }, this::mapper);

        return emp;
    }

    public void setName(Emp emp) {
        String sql = "UPDATE EMP2 SET ENAME=? WHERE EMPNO=?";
        jdbcTemplate.update((con)->{
          PreparedStatement pstmt = con.prepareStatement(sql);
          pstmt.setString(1, emp.getENAME());
          pstmt.setLong(2, emp.getEMPNO());

          return pstmt;
        });
    }

    public void setJob(Emp emp) {
        String sql = "UPDATE EMP2 SET JOB=? WHERE EMPNO=?";
        jdbcTemplate.update((con)->{
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, emp.getJOB());
            pstmt.setLong(2, emp.getEMPNO());

            return pstmt;
        });
    }

    private Emp mapper(ResultSet rs, int i) throws SQLException {
        Emp emp = new Emp();
        emp.setEMPNO(rs.getLong("EMPNO"));
        emp.setENAME(rs.getString("ENAME"));
        emp.setJOB(rs.getString("JOB"));

        return emp;
    }
}
