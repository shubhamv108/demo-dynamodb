package demo.dynamodb.repositories;

import demo.dynamodb.entities.ItemInfo;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ItemInfoRepository extends CrudRepository<ItemInfo, String> {
}
