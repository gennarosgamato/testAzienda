export class User {
    private _id: number;
    private _username: String;
    private _password: String;


    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
    public get username(): String {
        return this._username;
    }
    public set username(value: String) {
        this._username = value;
    }
    public get password(): String {
        return this._password;
    }
    public set password(value: String) {
        this._password = value;
    }
}