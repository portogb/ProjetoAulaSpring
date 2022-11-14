package br.com.senac.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
     
    Livro findByNome(String nome);

    @Query("SELECT DISTINCT l FROM Livro l JOIN FETCH l.professor p")
    List<Livro> findBookProfessor();
}
