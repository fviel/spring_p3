# spring_p3
Chuck Norris Joke app
Aplicação exemplo, com @Controller, @Service, DI via construtora e  thymeleaf.

Teste de herança, onde quiz validar se consigo transformar uma entidade, observei que claro que não....
Sendo, Fusca extends Veiculo, logo, faz sentido eu fazer algo como:
   Veiculo v1 = new Veiculo();
   Veiculo v2 = new Veiculo();
   Fusca f = new Fusca(v1) ;
   f = (Fusca) v2;
   Mas não faria sentido:
   v2 = (  Veículo) f;
   Pois por OO seria um.conflito, logo, se no código não faz sentido, no hbm tbm não pode fazer sentido.
   f e v1 são sim entidades distintas, é natural e lógica a geração de duplicatas.
