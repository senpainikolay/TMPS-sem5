package inMemoryDB

import "bytes"

type inMemoryDB struct {
	mapDB map[string][]byte
}

func GetDB() *inMemoryDB {
	return &inMemoryDB{
		make(map[string][]byte),
	}
}

func (db *inMemoryDB) LogInUser(name string, pw []byte) bool {
	_, exist := db.mapDB[name]
	if !exist {
		return false
	}
	dbPW := db.mapDB[name]
	pwIsCorrect := bytes.Compare(pw, dbPW)
	return pwIsCorrect == 0
}

func (db *inMemoryDB) RegisterUser(name string, pw []byte) bool {
	_, exist := db.mapDB[name]
	if exist {
		return false
	}
	db.mapDB[name] = pw
	return true
}
func (db *inMemoryDB) PrintUserPW(name string) (string, bool) {
	_, exist := db.mapDB[name]
	if exist {
		return string(db.mapDB[name]), false
	}
	return "user does not exist", true
}

func (db *inMemoryDB) DeleteUser(name string, em string) bool {
	_, exist := db.mapDB[name]
	if exist {
		delete(db.mapDB, name)
		return true
	}
	return false

}

func (db *inMemoryDB) UpdateUserPW(name string, pw []byte, tk string) bool {
	_, exist := db.mapDB[name]
	if exist {
		db.mapDB[name] = pw
		return true
	}
	return false
}
