#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>
int main() {
fork();
fork();
fork();
int pid=fork();
printf("Hello\n");
kill(pid,SIGKILL);
fork();
printf("Hello\n");
return 0;
}
