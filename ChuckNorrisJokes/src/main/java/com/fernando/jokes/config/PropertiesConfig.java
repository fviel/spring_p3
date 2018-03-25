/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fernando.jokes.config;

import com.fernando.jokes.testBean.Propriedades;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 *  Arquivo de properties citando mais de um property
 *  Observe que há duas formas de declarar um PropertySource.
 *   
 * @author Fernando
 */
@Configuration
//@PropertySource({"classpath:config.properties", "classpath:config2.properties"})
@PropertySources({
    @PropertySource("classpath:config.properties"),
    @PropertySource( "classpath:config2.properties")
})
public class PropertiesConfig {
    
 /*
    '@Value' irá colocar o valor que coloquei na chave de configuração no meu
    arquivo datasource.properties na variável abaixo.
    */
    @Value("${viel.pageTitle}")
    public String pageTitle;
    
    @Value("${viel.pageHeadLine}")
    public String pageHeadLine;

    
    @Bean
    public Propriedades propriedades(){
        Propriedades p = new Propriedades();
        p.setPageHeadTitle(pageHeadLine);
        p.setPageTitle(pageTitle);
        return p;
    }
      
    
    
    /*
    PropertySourcesPlaceholderConfigurer é uma classe do spring para tratar 
    properties, é um armazenador de properties.
    
    '@Bean' transforma o método abaixo em um bean do spring, quer pode ser
    utilizado em outras classes.
    */
    @Bean
    public static PropertySourcesPlaceholderConfigurer properties(){
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer  = new PropertySourcesPlaceholderConfigurer();
        return propertySourcesPlaceholderConfigurer;
        
    }
    
}

