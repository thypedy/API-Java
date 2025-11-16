package com.example.demo.config;

import com.example.demo.model.LearningPath;
import com.example.demo.model.User;
import com.example.demo.repository.LearningPathRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
    private final LearningPathRepository learningPathRepository;

    public DataSeeder(UserRepository userRepository, LearningPathRepository learningPathRepository) {
        this.userRepository = userRepository;
        this.learningPathRepository = learningPathRepository;
    }

    @Override
    public void run(String... args) {

        if (learningPathRepository.count() == 0) {

            LearningPath lp1 = new LearningPath();
            lp1.setTitulo("Inteligência Emocional e Psicologia Positiva no Trabalho");
            lp1.setDescricao("""
                Desenvolvimento de habilidades socioemocionais para promover bem-estar, 
                fortalecer vínculos humanos e construir ambientes psicologicamente seguros.
            """);
            lp1.setCompetenciasFuturo("Inteligência Emocional, Comunicação Empática, Segurança Psicológica");

            LearningPath lp2 = new LearningPath();
            lp2.setTitulo("Mindfulness, Autocuidado e Gestão Saudável do Estresse");
            lp2.setDescricao("""
                Técnicas de autocuidado, respiração, foco e atenção plena aplicadas à rotina profissional
                para prevenir burnout e melhorar a qualidade de vida.
            """);
            lp2.setCompetenciasFuturo("Mindfulness, Regulação Emocional, Hábitos Saudáveis");

            LearningPath lp3 = new LearningPath();
            lp3.setTitulo("Cultura de Confiança, Colaboração e Times Humanizados");
            lp3.setDescricao("""
                Estratégias de fortalecimento de equipes, mediação saudável de conflitos e construção de
                relações de confiança em ambientes híbridos e digitais.
            """);
            lp3.setCompetenciasFuturo("Colaboração, Mediação de Conflitos, Diversidade & Inclusão");

            learningPathRepository.save(lp1);
            learningPathRepository.save(lp2);
            learningPathRepository.save(lp3);

            System.out.println("🌱 Trilhas MindWork inseridas!");
        }

        if (userRepository.count() == 0) {

            User u1 = new User();
            u1.setNome("Carolina Mendes");
            u1.setEmail("carolina@mindwork.com");
            u1.setProfissaoAtual("Analista de People & Culture");

            User u2 = new User();
            u2.setNome("Diego Araújo");
            u2.setEmail("diego@mindwork.com");
            u2.setProfissaoAtual("Tech Lead e Facilitador de Equipes");

            User u3 = new User();
            u3.setNome("Fernanda Rocha");
            u3.setEmail("fernanda@mindwork.com");
            u3.setProfissaoAtual("Psicóloga Organizacional e Pesquisadora");

            userRepository.save(u1);
            userRepository.save(u2);
            userRepository.save(u3);

            System.out.println("🌿 Usuários MindWork inseridos!");
        }

        System.out.println("🚀 Seeds MindWork carregados com sucesso!");
    }
}
