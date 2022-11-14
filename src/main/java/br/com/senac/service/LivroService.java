package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.senac.entity.Livro;
import br.com.senac.repository.LivroRepository;

@Repository
public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> findAll(){
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Integer id){
        Optional<Livro> livro = livroRepository.findById(id);
        return livro;
    }

    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public void delete(Integer id){
        livroRepository.deleteById(id);
    }

    public Livro buscaPorNome(String nome){
        Livro livro = livroRepository.findByNome(nome);
        return livro;
    }
}
