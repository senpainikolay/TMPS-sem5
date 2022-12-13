package database

type DatabaseProcesses interface {
	RegisterUser(string, []byte) bool
	LogInUser(string, []byte) (bool, string)
	UpdateUserPW(string, []byte, string) bool
	DeleteUser(string, string) bool
	PrintUserPW(string) (string, bool)
}
