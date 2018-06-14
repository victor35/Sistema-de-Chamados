
/*

nome = Victor Marques de Souza dos Anjos
matricula = 17105795295175
disciplina = Programacão de computadores 1
objetivo = recebe dados de alunos calcula sua media e grava em um arquivo para o professor

*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef void* (*list_node_constructor_fn)(void*);
typedef void (*list_node_destructor_fn)(void*);

typedef struct list_node_t
{
	void* data;
	struct list_node_t* next;
	
}list_node_t;

typedef struct list_node_t* list_iterator_t;

typedef struct list_t
{
	list_node_t* head;
	list_node_t* tail;
	list_node_constructor_fn constructor;
	list_node_destructor_fn destructor;
	size_t size;
	
}list_t;

static list_node_t* list_new_node(void* data, list_node_constructor_fn constructor){

	list_node_t* new_node = malloc(sizeof(list_node_t));
	new_node->data = constructor(data);
	new_node->next = NULL;

	return new_node;

}

static void list_delete_node(list_node_t* node, list_node_destructor_fn destructor){

	destructor(node->data);

	free(node);
}

void list_initialize(list_t** l,list_node_constructor_fn constructor, list_node_destructor_fn destructor){

	(*l) = malloc(sizeof(list_t));
	(*l)->head = NULL;
	(*l)->tail = NULL;
	(*l)->constructor = constructor;
	(*l)->destructor = destructor;
	(*l)->size = 0;

}

size_t list_size(list_t* l){

	return l->size;
}

size_t list_empty(list_t* l){

	return list_size(l) == 0 ? 1 : 0;
}

void list_append(list_t* l, void* data){

	list_node_t* new_node = list_new_node(data,l->constructor);
	
	if(list_empty(l)){

		l->head = new_node;

	} else {

      l->tail->next = new_node;

	}

	l->tail = new_node;

	l->size++;

}

void list_remove_tail(list_t* l){
    
    list_node_t* node = l->tail;

    if(list_size(l) ==  1){

    	l->head = NULL;
    	l->tail = NULL;

    } else {
         
         list_iterator_t it = l->head;

         while(it->next!=l->tail){

         	it = it->next;

         }

         it->next = NULL;
        
         l->tail = it;
         
    }
    
    list_delete_node(node,l->destructor);

    l->size--;

}

void list_delete(list_t** l){

	while(!list_empty(*l)){
       
       list_remove_tail(*l);

	}

	free(*l);

	(*l) = NULL;
}

typedef struct aluno
{
	char nome[200];
	char curso[200];
	int matricula;
	double nota[3];
	char disciplina[200];
	double media;
	
}tipo_aluno;


void* constructor_aluno(void* data){

	void* ptr = malloc(sizeof(tipo_aluno));
	memcpy(ptr,data,sizeof(tipo_aluno));

	return ptr;
}

void destructor_aluno(void* data){

	free(data);
}

void imprime_aluno(tipo_aluno* a){

	printf("NOME : %s \n",a->nome);
	printf("CURSO : %s \n",a->curso);
	printf("MATRICULA : %d \n",a->matricula);
	printf("DISCIPLINA :%s\n",a->disciplina);

	int i;
	for (i = 0; i < 3; ++i)
	{
		printf("NOTA %d : %lf\n",i+1,a->nota[i]);
	}

	printf("MEDIA : %lf\n",a->media);
	
}

void le_aluno(tipo_aluno* a){

	printf("Entre com o nome do aluno\n");
	scanf("%s",a->nome);
	printf("Entre com o curso do aluno\n");
	scanf("%s",a->curso);
	printf("Entre com a matricula do aluno\n");
	scanf("%d",&a->matricula);
    printf("Entre com a disciplina do aluno\n");
	scanf("%s",a->disciplina);

	int i;
	for (i = 0; i < 3; ++i)
	{
		printf("Entre com a nota %d\n",i+1);
		scanf("%lf",&a->nota[i]);
	}
	

}

void imprime_lista(list_t* l){

	list_iterator_t it;

	for (it = l->head; it!=NULL; it = it->next)
	{
		imprime_aluno(it->data);
		printf("\n");
	}

	printf("\n");
}

void calcula_media_aritimetica(tipo_aluno* a){
    
    int i;
    double soma = 0;

   for(i = 0; i < 3; i++){
      
     soma+=a->nota[i];

   }

 a->media = soma / 3;

}

void calcula_media_ponderada(tipo_aluno* a, int *vet){


	int i;
    double soma = 0;
    double soma_pesos = 0;

   for(i = 0; i < 3; i++){
      
     soma = (soma + (a->nota[i] * (vet[i])));
     soma_pesos += vet[i]; 

   }

     a->media = soma/soma_pesos;

}

void gravar_struct(tipo_aluno* a, FILE* arq){

	fprintf(arq, " NOME = %s\n", a->nome);
	fprintf(arq, " CURSO = %s\n",a->curso);
	fprintf(arq, " MATRICULA = %d\n",a->matricula);
    fprintf(arq, " DISCIPLINA = %s\n",a->disciplina);
    
	int i;

	for (i = 0; i < 3; ++i)
	{
		fprintf(arq, " NOTA %d = %lf\n",i+1,a->nota[i]);
	}

	fprintf(arq, " MEDIA = %lf\n", a->media);

}

void gravar_lista(list_t* l, FILE* arq){

	list_iterator_t it;

	for (it = l->head; it!=NULL; it = it->next)
	{
		 gravar_struct(it->data,arq);
		 fprintf(arq,"\n");
	}
}

int main(void)
{
	 printf("********** PROGRAMA PARA CALCULAR NOTAS **********  \n");
    
     char nome_arq[200];
     printf("Entre com o nome do seu arquivo\n");
     scanf("%s",nome_arq);

     char nome_professor[200];

     FILE* arq = fopen(nome_arq,"a+");

     printf(" NOME DO PROFESSOR \n");
     scanf("%s",nome_professor);
     
     fprintf(arq, " nome professsor = %s\n",nome_professor);

     int escolha;

     printf("Que tipo de media o senhor deseja?\n");
     printf(" 1 - Media aritimetica \n");
     printf(" 2 - Media ponderada \n ");
     scanf("%d",&escolha);
     
     
     int vet[3];

     if(escolha == 2){
         
         for (int i = 0; i < 3; ++i)
         {
         	printf("Entre com o peso %d\n",i+1 );
         	scanf("%d",&vet[i]);
         }    

     }

	 list_t* l;
	 list_initialize(&l,constructor_aluno,destructor_aluno);
     
     int tam_turma;

     printf("Quantos alunos possui na sua turma\n");
     scanf("%d",&tam_turma);
     
     for (int i = 0; i < tam_turma; ++i)
     {

     	tipo_aluno a;
       
     	le_aluno(&a);
     	list_append(l,&a);


        if(escolha == 2){
          
          calcula_media_ponderada(l->tail->data,vet);

        } else {


        	calcula_media_aritimetica(l->tail->data);
        }
     	
     }

      gravar_lista(l,arq);
  
     imprime_lista(l);
     list_delete(&l);
      
	return 0;
}
