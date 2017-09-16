#include <unordered_map>
#include <string>
#include <cstdio>

using namespace std;

/*
 * Taken directly from opensource.apple.com's XNU sources to behave on a
 * Linux machine exactly as it does on my machine.
 *
 * Get next token from string *stringp, where tokens are possibly-empty
 * strings separated by characters from delim.
 *
 * Writes NULs into the string at *stringp to end tokens.
 * delim need not remain constant from call to call.
 * On return, *stringp points past the last NUL written (if there might
 * be further tokens), or is NULL (if there are definitely no more tokens).
 *
 * If *stringp is NULL, strsep returns NULL.
 */
char * strsep(char **stringp, const char *delim) {
	char *s;
	const char *spanp;
	int c, sc;
	char *tok;

	if ((s = *stringp) == NULL)
		return (NULL);
	for (tok = s;;) {
		c = *s++;
		spanp = delim;
		do {
			if ((sc = *spanp++) == c) {
				if (c == 0)
					s = NULL;
				else
					s[-1] = 0;
				*stringp = s;
				return (tok);
			}
		} while (sc != 0);
	}
	/* NOTREACHED */
}

char buf[80];

int main() {
	ssize_t nread;
	int vval;
	string cmdname, vname1, vname2, op;
	unordered_map<string, int> vars(10000);
	char *bufptr = &buf[0];
	size_t bufsize = 80;
	while((nread = getline(&bufptr, &bufsize, stdin)) > 9) {
		cmdname = string(strsep(&bufptr, " \r\n"));
		if (cmdname.compare("define") == 0) {
			sscanf(strsep(&bufptr, " "), "%d", &vval);
			vname1 = string(strsep(&bufptr, " \r\n"));
			vars[vname1] = vval;
		} else if (cmdname.compare("eval") == 0) {
			vname1 = string(strsep(&bufptr, " "));
			op = string(strsep(&bufptr, " "));
			vname2 = string(strsep(&bufptr, " \r\n"));
			if (vars.find(vname1) == vars.end() ||
					vars.find(vname2) == vars.end()) {
				puts("undefined");
			} else switch(op[0]) {
			case '<':
				if (vars[vname1] < vars[vname2]) puts("true");
				else puts("false");
				break;
			case '>':
				if (vars[vname1] > vars[vname2]) puts("true");
				else puts("false");
				break;
			case '=':
				if (vars[vname1] == vars[vname2]) puts("true");
				else puts("false");
				break;
			default:
				puts("ERROR1"); break;
			}
		} else puts("ERROR2");
	}
	return 0;
}

