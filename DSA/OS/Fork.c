#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

int main() {
    pid_t pid;

    // Fork a child process
    pid = fork();

    if (pid < 0) {
        // Fork failed
        fprintf(stderr, "Fork failed\n");
        return 1;
    } else if (pid == 0) {
        // Child process
        printf("This is the child process, PID: %d\n", getpid());
    } else {
        // Parent process
        printf("This is the parent process, PID: %d\n", getpid());
        printf("Child process PID: %d\n", pid);
    }

    return 0;
}
