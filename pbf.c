#include<stdio.h> 
#include<sys/wait.h> 
#include<unistd.h> 
int main() {
int pid = fork();
if(pid==0){
printf("Hello ");
}else{
wait(NULL);
printf("World");
}
} 

