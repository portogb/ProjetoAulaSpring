package br.com.senac.inicializacao;

import java.util.List;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Professor;
import br.com.senac.entity.Turma;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	AlunoService alunoService;
	
	@Autowired
	TurmaService turmaService;

	@Autowired
	CursoService cursoService;

	@Autowired
	ProfessorService professorService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		//ALUNO
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Arthur");
		
		Aluno aluno3 = new Aluno();
		aluno3.setNome("Jose");
		
		alunoService.salvar(aluno1);
		alunoService.salvar(aluno2);
		alunoService.salvar(aluno3);
		
		List<Aluno> listaAlunos = alunoService.buscarTodosAlunos();
		for (Aluno aluno : listaAlunos) {
			System.out.println(aluno.getNome());
		}
		
		Aluno aluno4 = alunoService.buscarPorId(1);
		System.out.println(aluno4.getNome());

		//alunoService.deletar(3);
		
		Aluno alunoAlterado = new Aluno();
		alunoAlterado.setId(1);
		alunoAlterado.setNome("Lucas Silva");
		alunoService.salvarAlteracao(alunoAlterado);

		//TURMA
		Turma turma1 = new Turma();
		turma1.setNome("2020.1N");
		Turma turma2 = new Turma();
		turma2.setNome("2020.2N");
		Turma turma3 = new Turma();
		turma3.setNome("2021.1N");

		turmaService.salvar(turma1);
		turmaService.salvar(turma2);
		turmaService.salvar(turma3);

		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
		for (Turma turma : listaTurmas) {
			System.out.println(turma.getNome());
		}

		Turma turma = turmaService.buscarPorId(1);
		System.out.println(turma.getNome());

		Turma turmaAlterada = new Turma();
		turmaAlterada.setId(1);
		turmaAlterada.setNome("2021.2N");
		turmaService.salvarAlteracao(turmaAlterada);

		//turmaService.deletar(1);

		//CURSO
		Curso curso1 = new Curso();
		curso1.setNome("NodeJs");
		Curso curso2 = new Curso();
		curso2.setNome("ASP.NET");
		Curso curso3 = new Curso();
		curso3.setNome("Spring Boot");

		cursoService.salvar(curso1);
		cursoService.salvar(curso2);
		cursoService.salvar(curso3);

		List<Curso> listaCursos = cursoService.buscarTodosCursos();
		for (Curso curso : listaCursos) {
			System.out.println(curso.getNome());
		}

		Curso curso = cursoService.buscarPorId(1);
		System.out.println(curso.getNome());

		Curso cursoAlterado = new Curso();
		cursoAlterado.setId(1);
		cursoAlterado.setNome("JavaScript");
		cursoService.salvarAlteracao(cursoAlterado);

		//cursoService.deletar(1);

		//PROFESSOR
		Professor professor1 = new Professor();
		professor1.setNome("Jesus");
		Professor professor2 = new Professor();
		professor2.setNome("Leonardo");
		Professor professor3 = new Professor();
		professor3.setNome("Bruno");

		professorService.salvar(professor1);
		professorService.salvar(professor2);
		professorService.salvar(professor3);

		List<Professor> listaProfessores = professorService.buscarTodosProfessores();
		for (Professor professor : listaProfessores) {
			System.out.println(professor.getNome());
		}

		Professor professor = professorService.buscarPorId(1);
		System.out.println(professor.getNome());

		Professor professorAlterado = new Professor();
		professorAlterado.setId(1);
		professorAlterado.setNome("Junior");
		professorService.salvarAlteracao(professorAlterado);

		//professorService.deletar(1);
	}
	
}
