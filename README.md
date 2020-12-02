# Classe-de-guitare
La dixième place au classement

## Docs
### Register 
#### Get Auth Code (/account/email POST)
__Request__
- email (String [Body])

__Response__
- 200 : OK

#### Register Account (/account POST)
__Request__
- authCode (String [Body])
- password (String [Body])
- githubId (String [Body])
- name (String [Body])

__Response__
- 201 : CREATED

### Login
#### Login (/auth POST)
__Request__
- email (String [Body])
- password (String [Body])

__Response__
- 200 : OK

### Get Information
#### Get Rank (/rank GET)
__Response__
- 200 : OK

#### Get My Account Information (/account/me GET)
__Request__
- Authorization (String [Header])

__Response__
- 200 : OK

#### Get Account Information (/account GET)
__Response__
- 200 : OK

### Change Information
#### Change Account Information (/account PUT)
__Request__
- Authorization (String [Header])
- name (String [Body])
- githubId (String [Body])
- description (String [Body])

__Response__
- 200 : OK

