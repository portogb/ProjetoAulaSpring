package br.com.senac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{
    
}
