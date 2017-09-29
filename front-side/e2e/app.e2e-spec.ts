import { AngularZooPage } from './app.po';

describe('angular-zoo App', () => {
  let page: AngularZooPage;

  beforeEach(() => {
    page = new AngularZooPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
