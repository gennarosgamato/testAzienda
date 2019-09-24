export class Persona {
    private _idp: number;
    private _city: String;
    private _cod_fiscale: String;
    private _date: String;
    private _gender: String;
    private _lastname: String;
    private _name: String;
    

public constructor(){
this._idp = 0;
this._name = "";
this._lastname = "";
this._city = "";
this._cod_fiscale = "";
this._date = "";
this._gender = "";
}

public get idp(): number {
    return this._idp;
}
public set idp(value: number) {
    this._idp = value;
}

public get city(): String {
    return this._city;
}
public set city(value: String) {
    this._city = value;
}

public get cod_fiscale(): String {
    return this._cod_fiscale;
}
public set cod_fiscale(value: String) {
    this._cod_fiscale = value;
}
public get date(): String {
    return this._date;
}
public set date(value: String) {
    this._date = value;
}
public get gender(): String {
    return this._gender;
}
public set gender(value: String) {
    this._gender = value;
}

public get lastname(): String {
    return this._lastname;
}
public set lastname(value: String) {
    this._lastname = value;
}

public get name(): String {
    return this._name;
}
public set name(value: String) {
    this._name = value;
}

}