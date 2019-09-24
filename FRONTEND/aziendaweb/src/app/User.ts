export class User {

    private id: number;
    private username: String;
    private password: String;

    public get _password(): String {
        return this.password;
    }
    public set _password(value: String) {
        this.password = value;
    }
    public get _username(): String {
        return this.username;
    }
    public set _username(value: String) {
        this.username = value;
    }
    public get _id(): number {
        return this.id;
    }
    public set _id(value: number) {
        this.id = value;
    }

}