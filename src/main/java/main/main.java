/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import controller.ProjectController;
import java.util.List;
import model.Project;


public class main {
    
     public static void main(String[] args) {      
       
    
    // TODO code application logic here
        ProjectController projectController = new ProjectController();
        Project project = new Project();
       // project.setName("Projeto teste");
       // project.setDescripition("descripition");
       // project.setCreatedAt(new Date());
       // project.setUpdatedAt(new Date());
        //System.out.println(project);
        //System.out.println(new Date(project.getCreatedAt().getTime()));           
       // projectController.save(project);
       //project.setId(1);
       ///project.setName("Novo nome do projeto");
       //project.setDescripition("Atualizando o projeto");
       //project.setCreatedAt(new Date());
       //project.setUpdatedAt(new Date());
       //projectController.update(project);
       
       List<Project> projects = projectController.getAll();
       System.out.println("Total de projetos = " + projects.size());
       
       projectController.removeById(1);
     }    
}
