export class Employee {
    private _id: number;
    private _nome: string;
    private _cognome: string;


    public get cognome(): string {
        return this._cognome;
    }
    public set cognome(value: string) {
        this._cognome = value;
    }
    public get nome(): string {
        return this._nome;
    }
    public set nome(value: string) {
        this._nome = value;
    }
    public get id(): number {
        return this._id;
    }
    public set id(value: number) {
        this._id = value;
    }
}