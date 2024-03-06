package org.tenosoft.temp.measurements.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tenosoft.temp.measurements.Model.Room;


public interface RoomRepository extends JpaRepository<Room, Long>{


	Optional<Room> findFirstByName(String name);
}
