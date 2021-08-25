#Rest Calculadora

Rest api calculadora

descrição

no presente projecto foi criada uma Rest api calculadora com objectivo de resolver as 4 operações básicas como demostra a listagem a baixo do funcionamento geral do projecto
1.Receber dados de um consumidor 
2.validar parâmetros
3. efectuar a operação desejada pêlo consumidor 
3.armazenar o resultado na fila do rabbitMQ
4.retornar o resultado ao consumidor

Nota: o normal o consumidor da api não deve receber a mensagem do resultado directamente da api mas sim receber o resultado partir de uma mensagem da fila do rabbitmq respeitado a ordem de entrada  

