package topServer.repository;

import topServer.entity.VisitorPO;

public interface VisitorRepository extends BaseRepository<VisitorPO> {

	public VisitorPO findByVisitIp(String visitIp);
}
