package app.repository;

import app.entity.SessionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.HashSet;
import java.util.List;

public interface SessionInfoRepository extends JpaRepository<SessionInfo, Long> {

    List<SessionInfo> findBySubtypeNot(String subtype);

    @Query("select grp from session")
    HashSet<String> findGrp();

    @Query("select count(*) from session where grp= ?1")
    int countGrp(String grp);

    @Query("select ssoid from session")
    HashSet<String> findSsoid();

    @Query("select grp from session where ssoid=?1")
    HashSet<String> findForms(String ssoid);
}

