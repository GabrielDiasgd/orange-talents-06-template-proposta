package br.com.zupacademy.gabriel.proposta.biometry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiometryRepository extends JpaRepository<Biometry, Long> {

}
