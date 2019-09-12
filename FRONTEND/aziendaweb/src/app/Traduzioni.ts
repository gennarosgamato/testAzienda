export class Traduzioni {
    private _id: number;
    private _lingua: String;
    private _testo: String;
    

    public constructor(){
        this._id = 0;
        this._lingua='';
        this._testo='';
        }

        public get testo(): String {
            return this._testo;
        }
        public set testo(value: String) {
            this._testo = value;
        }
        public get lingua(): String {
            return this._lingua;
        }
        public set lingua(value: String) {
            this._lingua = value;
        }
        public get id(): number {
            return this._id;
        }
        public set id(value: number) {
            this._id = value;
        }
}