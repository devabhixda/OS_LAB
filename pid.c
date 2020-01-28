#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main(){
int pid=fork();
if(pid==0){
printf("Child pid ");
int c = getpid();
printf("%d\n",c);
}else{
printf("Parent pid ");
int p = getpid();
printf("%d\n",p);
}
return 0;
}
